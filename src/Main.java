//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String part1_manifest = "resources/part1_manifest.txt";
        String part2_manifest = Part1.do_part1(part1_manifest);
        String part3_manifest = Part2.do_part2(part2_manifest);
        Movie[][]allMovies=Part3.do_part3(part3_manifest);

        Part3.navigateMovie(allMovies);
    }
}