
public class Principal {
    public static void main(String[] args) {
        char[] abecedario = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', 'a','b'};
        String frase = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyrq ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc sp";
        char[] fraseLista = frase.toCharArray();

        for (int i = 0; i < fraseLista.length; i++) {
            if(fraseLista[i] == ' '){
                System.out.print(" ");
                continue;
            }
            if(fraseLista[i] == '.'){
                System.out.print(".");
                continue;
            }
            if(fraseLista[i] == '('){
                System.out.print("(");
                continue;
            }
            if(fraseLista[i] == ')'){
                System.out.print(")");
                continue;
            }
            int cont = 0;
            while (fraseLista[i] != abecedario[cont]){
                cont++;
            }
            System.out.print(abecedario[cont+2]);
        }
    }
}