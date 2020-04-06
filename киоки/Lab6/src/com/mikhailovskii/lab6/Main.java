package com.mikhailovskii.lab6;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\ASUS\\Desktop\\android.png"));
            int width = image.getWidth();
            int height = image.getHeight();

            Color[] imageArray = convertImageToColorArray(image, width, height);

            StringBuilder message = new StringBuilder("Hello, this is message to encrypt");
            int addSymbols = width * height * 3 / 8 - message.length();
            message.append(" ".repeat(Math.max(0, addSymbols)));

            message = new StringBuilder(changeMessageToBitsSequence(message.toString()));

            int currentPosition = 0;
            for (int i = 0; i < imageArray.length; i++) {
                imageArray[i] = changeBitsInColor(imageArray[i],
                        new char[]{
                                message.charAt(currentPosition),
                                message.charAt(currentPosition + 1),
                                message.charAt(currentPosition + 2)
                        }
                );

                currentPosition += 3;
            }

            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            int[] imageRGB = new int[width * height];
            for (int i = 0; i < imageArray.length; i++) {
                imageRGB[i] = imageArray[i].getRGB();
            }

            newImage.setRGB(0, 0, width, height, imageRGB, 0, width);

            File outputFile = new File("C:\\Users\\ASUS\\Desktop\\output.png");
            ImageIO.write(newImage, "png", outputFile);

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////

            image = ImageIO.read(new File("C:\\Users\\ASUS\\Desktop\\output.png"));
            width = image.getWidth();
            height = image.getHeight();

            imageArray = convertImageToColorArray(image, width, height);

            StringBuilder res = new StringBuilder();
            for (Color color : imageArray) {
                res.append(getMessageFromColor(color));
            }

            StringBuilder output = new StringBuilder();

            for (int i = 0; i < res.length(); i += 8) {
                StringBuilder num = new StringBuilder();
                for (int j = i; j < i + 8; j++) {
                    num.append(res.charAt(j));
                }

                output.append((char) Integer.parseInt(num.toString(), 2));
            }

            output = new StringBuilder(output.toString().trim());
            System.out.println("Decoded: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String changeMessageToBitsSequence(String message) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int[] arr = toBitsArray(message.charAt(i));
            for (int value : arr) {
                output.append(value);
            }
        }
        return output.toString();
    }

    private static Color changeBitsInColor(Color color, char[] symbols) {
        int[] redArr = toBitsArray(color.getRed());
        int[] greenArr = toBitsArray(color.getGreen());
        int[] blueArr = toBitsArray(color.getBlue());

        redArr[redArr.length - 1] = Character.getNumericValue(symbols[0]);
        greenArr[greenArr.length - 1] = Character.getNumericValue(symbols[1]);
        blueArr[blueArr.length - 1] = Character.getNumericValue(symbols[2]);

        int redColor = bitsArrayToInt(redArr);
        int greenColor = bitsArrayToInt(greenArr);
        int blueColor = bitsArrayToInt(blueArr);

        color = new Color(redColor, greenColor, blueColor);

        return color;
    }

    private static Color[] convertImageToColorArray(BufferedImage image, int width, int height) {
        Color[] result = new Color[height * width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                result[row * width + col] = new Color(image.getRGB(col, row));
            }
        }

        return result;
    }

    private static int[] toBitsArray(int symbol) {
        int[] array = new int[8];
        int i = 7;

        while (symbol > 0) {
            array[i] = symbol % 2;
            symbol /= 2;
            i--;
        }

        return array;
    }

    private static int bitsArrayToInt(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int value : arr) {
            str.append(value);
        }
        return Integer.parseInt(str.toString(), 2);
    }

    private static String getMessageFromColor(Color color) {
        String output = "";

        int[] redArr = toBitsArray(color.getRed());
        int[] greenArr = toBitsArray(color.getGreen());
        int[] blueArr = toBitsArray(color.getBlue());

        output += redArr[redArr.length - 1];
        output += greenArr[greenArr.length - 1];
        output += blueArr[blueArr.length - 1];

        return output;
    }

}
