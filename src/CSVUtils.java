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
            throw new MissingQuotesException("Mismatched quotes in input line.");
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
}

