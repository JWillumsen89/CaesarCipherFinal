import java.util.Scanner;

public class Main {


  void userInterfaceStart() {

    System.out.println("1) \tCaesar");
    System.out.println("2) \tVigenére");
    System.out.println("0) \tExit");

    int inputNumberStart = userInputDecision();
    switch (inputNumberStart) {
      case 1:
        caesarMenu();
      case 2:
        //vigenere();
      default:
        System.exit(0);
    }
  }

  int userInputDecision() {
    Scanner in = new Scanner(System.in);
    System.out.print("Type your decision: ");
    int inputNumberStart = in.nextInt();
    System.out.println();
    return inputNumberStart;
  }

  void caesarMenu() {
    System.out.println("Caesar:");
    System.out.println("1) \tEncrypt");
    System.out.println("2) \tDecrypt");
    int inputNumberStart = userInputDecision();

    switch (inputNumberStart) {
      case 1:
        caesarEncryptMenu();
      case 2:
        caesarDecryptMenu();
      default:
        userInterfaceStart();
    }
  }

  String enterText() {
    Scanner in = new Scanner(System.in);
    System.out.print("Type text: ");
    String text = in.nextLine();
    text = text.toUpperCase();
    System.out.print("You entered: " + text);
    return text;
  }

  String enterDecryptText() {
    Scanner in = new Scanner(System.in);
    System.out.print("Type code text: ");
    String decryptText = in.nextLine();
    decryptText = decryptText.toUpperCase();
    System.out.print("You entered: " + decryptText);
    return decryptText;
  }

  int shiftValue() {
    Scanner in = new Scanner(System.in);
    System.out.print("\nEnter shift value (0-29): ");
    int shift = in.nextInt();
    System.out.println("You picked shift value: " + shift);
    return shift;
  }

  void caesarEncryptMenu() {
    System.out.println("Caesar Encrypting");
    String inputEncryptTextCaesar = enterText();
    int shiftValueCaesar = shiftValue();
    //TODO encrypting method
    System.out.println("Code text is: " + inputEncryptTextCaesar );
    System.out.println();
    whatNowMenu1();
  }

  void vigenere() {

  }

  void caesarDecryptMenu() {
    System.out.println("Caesar Decrypting");
    String inputDecryptTextCaesar = enterDecryptText();
    int shiftValueCaesar = shiftValue();
    //TODO decrypting method
    System.out.println("Code text is: " + inputDecryptTextCaesar );
    System.out.println();
    whatNowMenu2();


  }

  void whatNowMenu1() {
    System.out.println("Decide what to do now: \n");
    System.out.println("1) \tNew Text");
    System.out.println("2) \tDecrypt");
    System.out.println("0) \tMain menu");

    int inputNumberStart = userInputDecision();
    switch (inputNumberStart) {
      case 1:
        caesarEncryptMenu();
      case 2:
        caesarDecryptMenu();
      default:
        userInterfaceStart();
    }
  }

  void whatNowMenu2() {
    System.out.println("Decide what to do now: \n");
    System.out.println("1) \tNew CodeText");
    System.out.println("2) \tEncrypt");
    System.out.println("0) \tMain menu");

    int inputNumberStart = userInputDecision();
    switch (inputNumberStart) {
      case 1:
        caesarDecryptMenu();
      case 2:
        caesarEncryptMenu();
      default:
        userInterfaceStart();
    }
  }


  void go() {
    userInterfaceStart();

  }


  public static void main(String[] args) {
    new Main().go();
  }
}

