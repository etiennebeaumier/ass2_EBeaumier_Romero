// -----------------------------------------------------
//Assignment 2
//COMP 249
//Written by: Étienne Beaumier, 40211362
//             Romero FAUSTIN,   40234898
//Due date: 2024/03/27
//-----------------------------------------------------


import Exceptions.MissingQuotesException;

public class CSVUtils {

    /**
     * Removes commas inside quotes in a given line.
     *
     * @param line The line to remove commas from.
     * @return The line with commas inside quotes removed.
     * @throws MissingQuotesException If the input line has mismatched quotes.
     */
    public static String removeCommasInsideQuotes(String line) throws MissingQuotesException {
        long quoteCount = line.chars().filter(ch -> ch == '"').count();
        if (quoteCount % 2 != 0) {
            throw new MissingQuotesException();
        }

        boolean inQuotes = false;
        String result = "";

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            // Toggle the inQuotes flag if a quote is encountered
            if (c == '"') {
                inQuotes = !inQuotes;
                result += c;
            } else if (c == ',' && inQuotes) {
                // If a comma is found inside quotes, skip adding it to the result
                continue;
            } else {
                // Add the character to the result
                result += c;
            }
        }

        return result;
    }

    /**
     * Splits a given line by commas, ignoring commas inside quotes.
     *
     * @param line The line to split.
     * @return An array of strings containing the parts of the line.
     */
    public static String[] splitByCommas(String line) {
        String[] parts = new String[11];
        int index = 0;
        int start = 0;
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            // Toggle the inQuotes flag if a quote is encountered
            if (c == '"') {
                inQuotes = !inQuotes;
            }

            if (c == ',' && !inQuotes) {
                parts[index++] = line.substring(start, i);
                start = i + 1;
            }
        }

        parts[index] = line.substring(start);
        return parts;
    }
}

