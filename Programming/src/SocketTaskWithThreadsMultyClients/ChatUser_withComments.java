package SocketTaskWithThreadsMultyClients;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatUser_withComments {
    private static Integer portUp = null;
    private static Integer portDown = null;
    private static BufferedReader brUp;
    private static BufferedReader brDown;
    private static BufferedWriter bwUp;
    private static BufferedWriter bwDown;
    private static BufferedReader brConsole = new BufferedReader(new InputStreamReader(System.in));
    private static Socket socketUp = null;
    private static Socket socketDown = null;

    public static void main(String[] args) {

//----------Чтение аргументов вида: "java ChatUser portUp(если есть) PortDown--------
        if (args.length == 4) {
            portUp = Integer.parseInt(args[2]);
            portDown = Integer.parseInt(args[3]);
            System.out.println("My up port: " + portUp);
            System.out.println("My down port: " + portDown);
        } else {
            portDown = Integer.parseInt(args[2]);
            System.out.println("My down port: " + portDown);
        }

        try {
//-------------------------Подключение верхнего сокета--------------------------------
            if (portUp != null) {
                //Подключение к верхнему Сокету
                System.out.println("C'est une Up socket!");
                socketUp = new Socket("localhost", portUp);
                brUp = new BufferedReader(new InputStreamReader(socketUp.getInputStream()));
                bwUp = new BufferedWriter(new OutputStreamWriter(socketUp.getOutputStream()));
            }

// -------------------------------Верхний сокет--------------------------------------
            //Поток прослушивания верхнего сокета
            if (socketUp != null) {
                Thread threadForReadingUp = new Thread() {
                    public void run() {
                        System.out.println("Listen to Up socket!" + portUp);
                        try {
                            while (true) {
                                //Чтение, запись в консоль и отправка вниз
                                String upMess = brUp.readLine();
                                System.out.println("User: " + upMess);
                                if (socketDown != null) {
                                    writeMessage(bwDown, upMess);
                                    System.out.println("sent from Up to Down");
                                } else System.out.println("received from Up");
                            }
                        } catch (IOException e) {
                            System.out.println("Problem with UpSocket " + e);
                        }
                    }
                };
                threadForReadingUp.start();
            }

//-------------------------Запись своих сообщений в  консоль и отправка по сторонам------------------------
            Thread threadPrintMyMessage = new Thread() {
                public void run() {
                    System.out.println("Ready to write myMess");
                    try {
                        while (true) {
                            String myMess = brConsole.readLine();
                            System.out.println("THIS IS MY MESS: ");
                            writeMyMessage(myMess);
                          /*if (socketDown!=null) {
                                writeMessage(bwDown, myMess);
                                System.out.println("Sent Down");
                            }
                            if (socketUp!=null) {
                                writeMessage(bwUp, myMess);
                                System.out.println("Sent Up");
                            }
                            */
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPrintMyMessage.start();


//---------------------------Подключение нижего сокета----------------------
            if (portDown != null) {
                System.out.println("C'est une Down socket!");
                ServerSocket ss = new ServerSocket(portDown);
                socketDown = ss.accept();
                brDown = new BufferedReader(new InputStreamReader(socketDown.getInputStream()));
                bwDown = new BufferedWriter(new OutputStreamWriter(socketDown.getOutputStream()));
            }

//---------------------------------Нижний сокет--------------------------------------------------
            //Поток прослушивания нижнего сокета
            if (socketDown != null) {
                Thread threadForReadingDown = new Thread() {
                    public void run() {
                        System.out.println("Listen to Down socket!" + portDown);
                        try {
                            while (true) {
                                //Чтение, запись в консоль и отправка вверх
                                String downMess = null;
                                downMess = brDown.readLine();
                                System.out.println("User: " + downMess);
                                if (socketUp != null) {
                                    writeMessage(bwUp, downMess);
                                    System.out.println("sent from Down to Up");
                                }  else System.out.println("receiver from Down");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                threadForReadingDown.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void writeMessage(BufferedWriter bw, String message)throws IOException {
        bw.write(message, 0, message.length());
        bw.newLine();
        bw.flush();
    }

    public static void writeMyMessage(String myMess) {
        try {
            if (socketDown!=null) {
                writeMessage(bwDown, myMess);
                System.out.println("Sent Down");
            }
            if (socketUp!=null) {
                writeMessage(bwUp, myMess);
                System.out.println("Sent Up");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
