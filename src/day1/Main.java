package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String path = "M://listas.txt";

        try {
            List<Integer> lista1 = new ArrayList<>();
            List<Integer> lista2 = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                String[] partes = linha.trim().split("\\s+");

                if (partes.length >= 2) {
                    for (int i = 0; i < partes.length / 2; i++) {
                        try {
                            lista1.add(Integer.parseInt(partes[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter a linha para número: " + partes[i]);
                        }
                    }

                    for (int i = partes.length / 2; i < partes.length; i++) {
                        try {
                            lista2.add(Integer.parseInt(partes[i]));
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter a linha para número: " + partes[i]);
                        }
                    }
                } else {
                    System.out.println("Linha inválida, não contém elementos suficientes para dividir.");
                }
            }

            br.close();

            if (lista1.isEmpty() || lista2.isEmpty()) {
                System.out.println("As listas estão vazias.");
                return;
            }

            int somaMultiplicada = 0;
            for (int num1 : lista1) {
                int contador = 0;
                for (int num2 : lista2) {
                    if (num1 == num2) {
                        contador++;
                    }
                }
                somaMultiplicada += num1 * contador;
            }

            System.out.println("A soma dos produtos é: " + somaMultiplicada);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
