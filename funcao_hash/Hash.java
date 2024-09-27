import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static void main(String[] args) {
        String myText = "Em 1999 iniciam-se as atividades da FCI (Faculdade de Informática), como o curso de Ciência da Computação.";

        try {
            // Calcular SHA-256
            String sha256Hash = gerarHash(myText, "SHA-256");

            // Calcular MD5
            String md5Hash = gerarHash(myText, "MD5");

            System.out.println("Frase: " + myText + "\nSHA-256: " + sha256Hash + "\nMD5:" + md5Hash);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Algoritmo de hash não suportado: " + e.getMessage());
        }
    }

    private static String gerarHash(String input, String algoritmo) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algoritmo);

        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // Converter os bytes do hash para a representação hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }
}
