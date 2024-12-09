import java.util.Arrays;

public class TablaFrecuencias {
    public static void main(String[] args) {

        double[] dataSet = {
                20.3, 23.5, 15.7, 30.4, 23.5, 15.1, 16.3, 30.7, 20.9, 15.7,
                23.3, 14.5, 23.5, 16.2, 18.0, 16.6, 28.7, 10.8, 22.1, 30.4,
                30.4, 20.3, 50.4, 14.5, 20.2, 16.6, 23.3, 10.8, 22.1, 23.3,
                30.5, 10.8, 20.8, 27.1, 20.9, 40.5, 17.5, 23.6, 18.0, 22.6
        };


        int numClases = 6;


        double min = Arrays.stream(dataSet).min().orElse(0);
        double max = Arrays.stream(dataSet).max().orElse(0);
        double rango = max - min;


        double amplitud = Math.ceil(rango / numClases);


        double[] limitesInferiores = new double[numClases];
        double[] limitesSuperiores = new double[numClases];
        int[] frecuencias = new int[numClases];
        double[] puntosMedios = new double[numClases];
        int[] frecuenciaAcumulativa = new int[numClases];
        double[] frecuenciaRelativa = new double[numClases];
        double[] porcentaje = new double[numClases];


        for (int i = 0; i < numClases; i++) {
            limitesInferiores[i] = min + i * amplitud;
            limitesSuperiores[i] = limitesInferiores[i] + amplitud;
            puntosMedios[i] = (limitesInferiores[i] + limitesSuperiores[i]) / 2;
        }


        for (double dato : dataSet) {
            for (int i = 0; i < numClases; i++) {
                if (dato >= limitesInferiores[i] && dato < limitesSuperiores[i]) {
                    frecuencias[i]++;
                    break;
                }
            }
        }


        int acumulado = 0;
        for (int i = 0; i < numClases; i++) {
            acumulado += frecuencias[i];
            frecuenciaAcumulativa[i] = acumulado;
            frecuenciaRelativa[i] = (double) frecuencias[i] / dataSet.length;
            porcentaje[i] = frecuenciaRelativa[i] * 100;
        }


        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-20s %-15s %-15s%n",
                "Clase", "Límite Inf.", "Límite Sup.", "Punto Medio",
                "Frecuencia", "Frecuencia Acum.", "Frecuencia Rel.", "Porcentaje");

        for (int i = 0; i < numClases; i++) {
            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f %-15d %-20d %-15.2f %-15.2f%n",
                    (i + 1), limitesInferiores[i], limitesSuperiores[i], puntosMedios[i],
                    frecuencias[i], frecuenciaAcumulativa[i], frecuenciaRelativa[i], porcentaje[i]);
        }
    }
}
