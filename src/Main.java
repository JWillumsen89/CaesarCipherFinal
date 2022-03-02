import java.util.Scanner;

public class Main {

  void userInterfaceStart() {

    System.out.println("1) \tCaesar");
    System.out.println("0) \tExit");

    int inputNumberStart = userInputDecision();
    switch (inputNumberStart) {
      case 1:
        caesarMenu();
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
    System.out.print("\nEnter shift value (0-29): ");
    shiftValue();

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
//Shift value hardcoded! and modulus not made to circle alphabet, so last letters in alphabet cant be used.
  int shiftValue() {
    /*Scanner in = new Scanner(System.in);
    System.out.print("\nEnter shift value (0-29): ");
    int shift = in.nextInt();
    System.out.println("You picked shift value: " + shift);*/
    int shift = 3;
    return shift;
  }

  void caesarEncryptMenu() {
    System.out.println("Caesar Encrypting");
    caesarEncrypt();
    System.out.println();
    whatNowMenu1();
  }

  void caesarDecryptMenu() {
    System.out.println("Caesar Decrypting");
    caesarDecrypt();
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

  void caesarEncrypt() {
    String text = enterText();
    int[] encryptedNumbers = encryptMethod(text);
    String decryptedText = decryptedMethod(encryptedNumbers);
    int shiftValueCaesar = shiftValue();
    System.out.println("\nDecrypted text: " + decryptedText);
  }

  void caesarDecrypt() {
    String decryptText = enterDecryptText();
    int[] encryptedNumbers = encryptMethod(decryptText);
    String decryptedText = encryptedMethod(encryptedNumbers);
    int shiftValueCaesar = shiftValue();
    System.out.println("\nEncrypted text: " + decryptedText);
  }

  public int[] encryptMethod(String text) {
    int[] numbers = new int[text.length()];
    for (int i = 0; i < text.length(); i++) {
      char charAtIndex = text.charAt(i);
      int indexOfChar = letterToNumber(charAtIndex);
      numbers[i] = indexOfChar;
    }
    return numbers;
  }

  public String decryptedMethod(int[] numbers) {
    String text = "";
    char arrayNumbers;
    for (int i = 0; i < numbers.length; i++) {
      arrayNumbers = numberToLetter(numbers[i] + shiftValue());
      text += arrayNumbers;
    }
    return text;
  }

  public String encryptedMethod(int[] numbers) {
    String text = "";
    char c;
    for (int i = 0; i < numbers.length; i++) {
      c = numberToLetter(numbers[i] - shiftValue());
      text += c;
    }
    return text;
  }

  public char numberToLetter(int number) {
    String alphabet = " ABCDEFGHIJKLMNOPQRSTVWXYZÆØÅ";
    char letter = alphabet.charAt(number);
    return letter;
  }

  public int letterToNumber(char letter) {
    String alphabet = " ABCDEFGHIJKLMNOPQRSTVWXYZÆØÅ";
    int number = alphabet.indexOf(letter);
    return number;
  }


  void go() {
    userInterfaceStart();

  }


  public static void main(String[] args) {
    new Main().go();
  }
}

