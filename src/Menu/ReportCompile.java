package Menu;

import net.sf.jasperreports.engine.*;

public class ReportCompile {
    public static void main(String[] args) {
        try {
            // Array nama laporan yang ingin dikompilasi
            String[] reportNames = {
                "laporanbalita",
                "laporanibuhamil",
                "laporan_pemeriksaan_balita",
                "laporan_pemeriksaan_ibu",
                "laporan_gizi_balita",
                "laporan_gizi_ibu",
                "laporankader",
                    "laporan_imunisasi"
            };

            for (String reportName : reportNames) {
                String sourceFileName = "src/report/" + reportName + ".jrxml";
                String outputFileName = "src/report/" + reportName + ".jasper";

                System.out.println("Compiling report: " + sourceFileName);

                long start = System.currentTimeMillis();

                JasperCompileManager.compileReportToFile(sourceFileName, outputFileName);

                long end = System.currentTimeMillis();

                System.out.println("Report compiled successfully to: " + outputFileName);
                System.out.println("Compilation time: " + (end - start) + " ms");
                System.out.println("--------------------------------------------------");
            }

        } catch (JRException e) {
            System.err.println("Error compiling report!");
            e.printStackTrace();
        }
    }
}
