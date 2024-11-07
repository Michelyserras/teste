public class App {
    public static void main(String[] args) throws Exception {
        double SP = 67836.43;
        double RJ = 36678.66;
        double MG = 29229.88;
        double ES = 27165.48;
        double Outros = 19849.53;

        double soma = SP + RJ + MG + ES + Outros;

        System.out.println("Total Faturamento = " + soma);
        System.out.println("Percentual SP = " + (SP/soma)*100 + "%\n");
        System.out.println("Percentual RJ = " + (RJ/soma)*100 + "%\n");
        System.out.println("Percentual Mg = " + (MG/soma)*100 + "%\n");
        System.out.println("Percentual Es = " + (ES/soma)*100 + "%\n");
        System.out.println("Percentual Outros = " + (Outros/soma)*100 + "%\n");
    }
}
