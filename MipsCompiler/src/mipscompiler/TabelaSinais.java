package mipscompiler;

/**
 *
 * @author Gustavo Schroeder
 */
public class TabelaSinais {
    String type;
    
    public TabelaSinais(String type){
        this.type= type;
    }
    
    public String geraTabela(String op, char regWrite, char regDst, char aluDst,
            char branch, char memWrite, char memToReg, String aluOp, char jump){
        String tabela = "Instruction | Opcode | RegWrite | RegDst | ALUSrc | Branch | MemWrite | MemtoReg | ALUOp | Jump\n";
        tabela += "  " + type + "       " + op + "       " + regWrite+ "         " + regDst + "       " +
                aluDst + "        " + branch + "         " + memWrite + "          " + memToReg+ "          " +
                aluOp + "     " + jump + "   \n\n\n\n";
        return tabela;
    }
}
