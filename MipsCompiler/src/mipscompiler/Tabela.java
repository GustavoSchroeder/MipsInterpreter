package mipscompiler;

/**
 *
 * @author Gustavo Schroeder
 */
public class Tabela {

    private char type;
    private String tabela;
    public Tabela(char type) {
        this.type = type;
    }

    public String geraTabela(String op, String rs, String rt, String rd, String sht, String funct,String imm, String addr) {
        if(type == 'r'){
            tabela = null;
            tabela = " Op  |   RS  |  RT  | RD  | SHAMT | FUNCT  |\n" + 
                    op + "  " + rs + "  " + rt + "  " + rd + "  " + sht + "  " + funct + "\n";
        }
        else if(type == 'i'){
            tabela = null;
            tabela = "  Op  | RS  | RT  |        IMM     |\n" + 
                    op + "  " + rs + "  "  + rt + "  " + imm + "\n";                   
        }
        else if(type == 'j'){
            tabela = null;
            tabela = "  OP  |           ADDR            \n" + 
                    op + " " + addr + "\n";
        }
        return tabela;
    }
}
