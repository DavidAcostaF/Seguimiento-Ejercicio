package extras;

/**
 *
 * @author alex_
 */
public class ValidadoresPresentacion {

    // Verificar que un string sea solo texto y permita los caracteres especiales "(" y ")". Máximo 30 caracteres
    public static boolean esSoloTexto(String input) {
        return input.matches("^[a-zA-Z\\s()]{1,30}$");
    }

    // Verificar que un string contenga solo números enteros de hasta 4 dígitos
    public static boolean esNumeroEntero(String input) {
        return input.matches("^\\d{1,4}$");
    }

    // Verificar que un string contenga números con hasta 2 decimales (opcionales)
    public static boolean esNumeroDecimal(String input) {
        return input.matches("^\\d+(\\.\\d{1,2})?$");
    }

    // Verificar que una contraseña tenga al menos 8 caracteres, incluyendo un caracter especial, una mayúscula, una minúscula y un número
    public static boolean esContrasenaValida(String input) {
        return input.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\*¡?()!_\\-]).{8,}$");
    }

}
