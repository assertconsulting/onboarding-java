package support;

import java.text.MessageFormat;

public class FrameworkLogger {
    public static void LogPreviousMethod(int level) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length > 2) {
            StackTraceElement callingMethod = stackTrace[level];
            String methodName = callingMethod.getMethodName();
            System.out.println("Method caller: " + methodName);
            System.out.println("Método chamador: " + methodName);
        } else {
            System.out.println("Impossible to determinate the method caller");
            System.out.println("Não é possível determinar o método chamador.");
        }
    }
    public static void LogElement_Found(Behaviors.GetElementBy by, String webElement){
        System.out.println("");
        LogPreviousMethod(4);
        System.out.println(MessageFormat.format("\t Element \"{1}\" successfully found by {0}", by, webElement));
        System.out.println(MessageFormat.format("\t Elemento \"{1}\" encontrado com sucesso por {0}", by, webElement));
    }

    public static void LogElement_NotFound(Behaviors.GetElementBy by, String webElement){
        System.out.println("");
        LogPreviousMethod(4);
        System.out.println(MessageFormat.format("\t Element \"{1}\" was not found by {0}", by, webElement));
        System.out.println("\t Tip: Consider working with the development team to include an ID in this web element.");
        System.out.println("\t Dica: Considere trabalhar com a equipe de desenvolvimento para incluir um ID neste elemento web.");
    }

    public static  void LogElement_Click(Behaviors.GetElementBy by, String webElement){
        System.out.println("");
        LogPreviousMethod(4);
        System.out.println(MessageFormat.format("\t Element \"{1}\" was successfully clicked by {0}", by, webElement));
        System.out.println(MessageFormat.format("\t Elemento \"{1}\" foi clicado com sucesso por {0}", by, webElement));
    }

    public static void LogElement_Input(String text, String webElement){
        System.out.println("");
        LogPreviousMethod(4);
        System.out.println(MessageFormat.format("\t The value \"{0}\" was inserted on element \"{1}\"", text, webElement));
        System.out.println(MessageFormat.format("\t Foi inserido o valor \"{0}\" no campo \"{1}\"", text, webElement));
    }

    public static void LogStringAssertions(String expected_message, String actual_message){
        System.out.println("");
        LogPreviousMethod(4);
        System.out.println(MessageFormat.format("\t Expected message: \"{0}\" ", expected_message));
        System.out.println(MessageFormat.format("\t Received message: \"{0}\" ", actual_message));
        System.out.println(MessageFormat.format("\t Mensagem esperada: \"{0}\" ", expected_message));
        System.out.println(MessageFormat.format("\t Mensagem recebida: \"{0}\" ", actual_message));
    }
}
