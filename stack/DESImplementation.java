// x:5 AES
//  • Implement the process of Key Expansion and Encryption using AES. 
// • Get a plain text from the user.
//  • Perform Key Expansion (Display only round 1 key) and Encryption (Intermediate 
// result at the end of round 1).
//  • Contents in Observation
//  • Aim
//  • Algorithm
//  • Problem Solving
//  • PT=0x 01020304 05060708 09101112 13141516 ; Key: 0x 11121314 15161718 19202122 
// 23242526
//  • What is the Intermediate Cipher Text that you get on performing the first round for the given 
// plain text and key.
//  • Output
//  • Result

import java.util.*;

public class DESImplementation {
    // Initial Permutation table
    private static final int[] IP = {
        58, 50, 42, 34, 26, 18, 10, 2,
        60, 52, 44, 36, 28, 20, 12, 4,
        62, 54, 46, 38, 30, 22, 14, 6,
        64, 56, 48, 40, 32, 24, 16, 8,
        57, 49, 41, 33, 25, 17, 9, 1,
        59, 51, 43, 35, 27, 19, 11, 3,
        61, 53, 45, 37, 29, 21, 13, 5,
        63, 55, 47, 39, 31, 23, 15, 7
    };

    // PC-1 table for key generation
    private static final int[] PC1 = {
        57, 49, 41, 33, 25, 17, 9,
        1, 58, 50, 42, 34, 26, 18,
        10, 2, 59, 51, 43, 35, 27,
        19, 11, 3, 60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
        7, 62, 54, 46, 38, 30, 22,
        14, 6, 61, 53, 45, 37, 29,
        21, 13, 5, 28, 20, 12, 4
    };

    // PC-2 table for key generation
    private static final int[] PC2 = {
        14, 17, 11, 24, 1, 5,
        3, 28, 15, 6, 21, 10,
        23, 19, 12, 4, 26, 8,
        16, 7, 27, 20, 13, 2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
    };

    // Expansion table
    private static final int[] E = {
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };

    // S-boxes
    private static final int[][][] SBOX = {
        // S1
        {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
         {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
         {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
         {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}},
        // S2-S8 would go here (omitted for brevity)
    };

    // P-box permutation
    private static final int[] P = {
        16, 7, 20, 21, 29, 12, 28, 17,
        1, 15, 23, 26, 5, 18, 31, 10,
        2, 8, 24, 14, 32, 27, 3, 9,
        19, 13, 30, 6, 22, 11, 4, 25
    };

    public static void main(String[] args) {
        // Given plain text and key
        long plainText = 0x0002000000000001L;
        long key = 0x0002000000000002L;

        System.out.println("Plain Text: " + String.format("%016X", plainText));
        System.out.println("Key: " + String.format("%016X", key));

        // Generate first round key
        long roundKey = generateRoundKey(key, 1);
        System.out.println("Round 1 Key: " + String.format("%012X", roundKey));

        // Perform first round of encryption
        long afterFirstRound = performFirstRound(plainText, roundKey);
        System.out.println("After Round 1: " + String.format("%016X", afterFirstRound));
    }

    private static long generateRoundKey(long key, int round) {
        // Perform PC-1 permutation
        long permutedKey = permute(key, PC1, 64, 56);
        
        // Split into left and right halves
        int c = (int) (permutedKey >>> 28);
        int d = (int) (permutedKey & 0x0FFFFFFF);

        // Perform left circular shift (for round 1, shift is by 1)
        c = ((c << 1) | (c >>> 27)) & 0x0FFFFFFF;
        d = ((d << 1) | (d >>> 27)) & 0x0FFFFFFF;

        // Combine C and D
        long combined = ((long)c << 28) | d;

        // Perform PC-2 permutation
        return permute(combined, PC2, 56, 48);
    }

    private static long performFirstRound(long plainText, long roundKey) {
        // Initial permutation
        long ip = permute(plainText, IP, 64, 64);

        // Split into left and right halves
        int left = (int) (ip >>> 32);
        int right = (int) ip;

        // Expansion
        long expanded = permute(right, E, 32, 48);

        // XOR with round key
        long xored = expanded ^ roundKey;

        // S-box substitution
        int sboxOutput = sBox(xored);

        // P-box permutation
        int pboxOutput = (int) permute(sboxOutput, P, 32, 32);

        // XOR with left half
        int newRight = left ^ pboxOutput;

        // Combine the halves (right becomes left, new right from calculation)
        return ((long)right << 32) | (newRight & 0xFFFFFFFFL);
    }

    private static long permute(long input, int[] table, int inputBits, int outputBits) {
        long output = 0;
        for (int i = 0; i < table.length; i++) {
            int bit = (int) (input >>> (inputBits - table[i])) & 1;
            output = (output << 1) | bit;
        }
        return output;
    }

    private static int sBox(long input) {
        int output = 0;
        for (int i = 0; i < 8; i++) {
            int chunk = (int) ((input >>> (42 - i*6)) & 0x3F);
            int row = ((chunk & 0x20) >>> 4) | (chunk & 0x01);
            int col = (chunk >>> 1) & 0x0F;
            output = (output << 4) | SBOX[i][row][col];
        }
        return output;
    }
}