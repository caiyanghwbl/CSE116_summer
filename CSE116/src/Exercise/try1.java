package Exercise;

import java.util.Scanner;

public class try1 {

//method to check wHether a valid command is entered

static boolean checkCommand(String command)

{

boolean check = false;

String[] strings = {"A","B","C","Q"};

for(int i=0;i<strings.length;i++)

{

//checking whether the entered command is from expected charecters

if(strings[i].equals(command))

{

check = true;

}

}

return check;

}

//Getting the value of hypotenuse

static double hypotenuse(int A, int B)

{

double squareRoot = 0;

A = A*A;

B= B*B;

int c = A+B;

squareRoot = Math.sqrt(c);

return squareRoot;

}

public static void main(String[] args)

{

Scanner sc = new Scanner(System.in);

boolean quit =false;

int A = 0;

int B = 0;

//this loop runs untill Q commond is given

//as we are setting quit = true in the loop if(command.equals("Q"))

while(quit == false)

{

boolean check = false;

boolean checkA = false;

boolean checkB = false;

System.out.println("Enter a command");

String command = sc.nextLine();

//passing the entered string to checkcommand method to check valid string is entered

check = checkCommand(command);

while(check == false)

{

System.out.println("Enter a valid Command");

command = sc.nextLine();

check = checkCommand(command);

}

//loop for the command A

if(command.equals("A"))

{

while(checkA==false)

{

try{

System.out.println("enter value for side A");

//If anything other than integers are given an exception is thrown

A = Integer.parseInt(sc.nextLine());

System.out.println(A+"A");

checkA = true;

}catch (Exception e) {

System.out.println("Enter a Valid number");

}

}

}

//loop for the command B

if(command.equals("B"))

{

while(checkB==false)

{

try{

System.out.println("enter value for side B");

//If anything other than integers are given an exception is thrown

B = Integer.parseInt(sc.nextLine());

checkB = true;

}catch (Exception e) {

System.out.println("Enter a Valid number");

}

}

}

if(command.equals("C"))

{

//passing A and B to get hypotenuse value

double hypo = hypotenuse(A, B);

System.out.println("Hypotenuse : "+hypo);

//setting A and B as 0 since they hold the previous loop values inside them

A = 0;

B = 0;

}

if(command.equals("Q"))

{

quit=true;

System.out.println("Exit successful");

}

}

}

}