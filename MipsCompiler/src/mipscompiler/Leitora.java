package mipscompiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo Lazarotto Schroeder
 */
public class Leitora {

    String tabelas = new String();

    private int returnN(String word) {
        if (word.contains("$t0")) {
            return 8;
        } else if (word.contains("$t1")) {
            return 9;
        } else if (word.contains("$t2")) {
            return 10;
        } else if (word.contains("$t3")) {
            return 11;
        } else if (word.contains("$t4")) {
            return 12;
        } else if (word.contains("$t5")) {
            return 13;
        } else if (word.contains("$t6")) {
            return 14;
        } else if (word.contains("$t7")) {
            return 15;
        } else if (word.contains("$s0")) {
            return 16;
        } else if (word.contains("$s1")) {
            return 17;
        } else if (word.contains("$s2")) {
            return 18;
        } else if (word.contains("$s3")) {
            return 19;
        } else if (word.contains("$s4")) {
            return 20;
        } else if (word.contains("$s5")) {
            return 21;
        } else if (word.contains("$s6")) {
            return 22;
        } else if (word.contains("$s7")) {
            return 23;
        } else if (word.contains("t8")) {
            return 24;
        } else if (word.contains("t9")) {
            return 25;
        } else if (word.contains("$zero")) {

            return 0;

        }
        return 0;
    }

    public void fazLeitura() throws FileNotFoundException, Exception {
        int cont = 0;
        BufferedReader in;
        FileReader fe;
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fe = new FileReader(jfc.getSelectedFile());
            in = new BufferedReader(fe);
        } else {
            throw new FileNotFoundException();
        }
        String line = null;

        while ((line = in.readLine()) != null) {
            cont++;
            if ("".equals(line)) {
                line = in.readLine();
                cont++;
            }

            if (line.indexOf("add") >= 0) {
                String word[] = line.split(",");
                Integer rd = returnN(word[0]);
                Integer rs = returnN(word[1]);
                Integer rt = returnN(word[2]);
                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;

                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir, "00000", Integer.toBinaryString(32), null, null);
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("subi") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                Integer rt = returnN(word[1]);
                char n = word[2].charAt(word[2].indexOf(" ") + 1);
                String num = new String();
                num += n;
                int nume = Integer.parseInt(num);
                int rtSub = rt - nume;
                String number = Integer.toBinaryString(rtSub);
                String aux = new String();
                if (number.length() < 16) {
                    for (int i = number.length(); i < 16; i++) {
                        aux += "0";
                    }
                    aux += number;
                }
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("100011", fi, sec,
                        null, null, null, aux, null);
                TabelaSinais ts = new TabelaSinais("SUBI");
                tabelas += ts.geraTabela("100011", '1', '0', '1', '0', '0', '0', "00", '0');
            } else if (line.indexOf("sub") >= 0) {
                String word[] = line.split(",");
                Integer rd = returnN(word[0]);
                Integer rs = returnN(word[1]);
                Integer rt = returnN(word[2]);
                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;

                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir,
                        "00000", Integer.toBinaryString(34), null, null);
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("and") >= 0) {
                String word[] = line.split(",");
                Integer rd = returnN(word[0]);
                Integer rs = returnN(word[1]);
                Integer rt = returnN(word[2]);

                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;
                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir, "00000", Integer.toBinaryString(36), null, null);
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("not") >= 0) {
                String word[] = line.split(",");
                Integer rd = returnN(word[0]);
                Integer rs = returnN(word[1]);
                Integer rt = 0;

                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;
                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir,
                        "00000", Integer.toBinaryString(39), null, null);
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("beq") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                Integer rt = returnN(word[1]);
                Integer num = Integer.parseInt(word[2]);
                String write = Integer.toBinaryString(num);
                String writeWord = new String();
                if (write.length() < 16) {
                    for (int i = word.length; i < 16; i++) {
                        writeWord += "0";
                    }
                    writeWord += write;
                }
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("000100", fi, sec, null, null, null, writeWord, null);
                TabelaSinais ts = new TabelaSinais("BEQ");
                tabelas += ts.geraTabela("000100", '0', 'X', '0', '1', '0', 'X', "01", '0');
            } else if (line.indexOf("slt") >= 0) {
                String word[] = line.split(",");
                Integer rd = returnN(word[0]);
                Integer rs = returnN(word[1]);
                Integer rt = returnN(word[2]);

                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;
                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir, "00000", Integer.toBinaryString(42), null, null);
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("ori") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                Integer rt = returnN(word[1]);
                char n = word[2].charAt(word[2].indexOf(" ") + 1);
                String num = new String();
                num += n;
                Integer number = Integer.parseInt(num);
                String numberB = Integer.toBinaryString(number);
                cont = 0;
                String c = "0";
                for (int i = 0; i < numberB.length(); i++) {
                    cont++;
                }

                if (cont != 16) {
                    for (int i = 0; i < (16 - (cont + 1)); i++) { //cont +1 para garantir os 16 bits
                        c += "0";
                    }
                }
                c += numberB;
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("001101", fi, sec, null, null, null, c, null);
                TabelaSinais ts = new TabelaSinais("ORI");
                tabelas += ts.geraTabela("001101", '1', '0', '1', '0', '0', '0', "00", '0');
            } else if (line.indexOf("addi") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                Integer rt = returnN(word[1]);
                char n = word[2].charAt(word[2].indexOf(" ") + 1);
                String num = new String();
                num += n;
                Integer auxi = Integer.parseInt(num);
                String number = Integer.toBinaryString(auxi);
                String aux = null;
                if (number.length() < 16) {
                    for (int i = number.length(); i < 16; i++) {
                        aux += "0";
                    }
                    aux += number;
                }
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("001000", fi, sec, null, null, null, aux, null);
                TabelaSinais ts = new TabelaSinais("ADDI");
                tabelas += ts.geraTabela("001000", '1', '0', '1', '0', '0', '0', "00", '0');
            } else if (line.indexOf("or") >= 0) {
                String word[] = line.split(",");
                int rd = returnN(word[0]);
                int rs = returnN(word[1]);
                int rt = returnN(word[2]);
                String f = Integer.toBinaryString(rd);
                String s = Integer.toBinaryString(rs);
                String th = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                String thir = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                if (th.length() < 5) {
                    for (int i = th.length(); i < 5; i++) {
                        thir += 0;
                    }
                }
                fi += f;
                sec += s;
                thir += th;
                Tabela t = new Tabela('r');
                tabelas += t.geraTabela("000000", fi, sec, thir, "00000", Integer.toBinaryString(37), "", "");
                TabelaSinais ts = new TabelaSinais("R-type");
                tabelas += ts.geraTabela("000000", '1', '1', '0', '0', '0', '0', "10", '0');
            } else if (line.indexOf("andi") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                Integer rt = returnN(word[1]);
                char n = word[2].charAt(word[2].indexOf(" ") + 1);
                String num = new String();
                num += n;
                Integer auxi = Integer.parseInt(num);
                String number = Integer.toBinaryString(auxi);
                String aux = null;
                if (number.length() < 16) {
                    for (int i = number.length(); i < 16; i++) {
                        aux += "0";
                    }
                    aux += number;
                }
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("001111", fi, sec, null, null, null, aux, null);
                TabelaSinais ts = new TabelaSinais("ANDI");
                tabelas += ts.geraTabela("001111", '1', '0', '1', '0', '0', '0', "00", '0');
            } else if (line.indexOf("lw") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                String rtAux = new String();
                String num = new String();
                String numero = new String();
                int aux = line.indexOf("(");
                int auxi = line.indexOf(")");
                int aux1 = line.lastIndexOf(",");
                for (int i = aux1 + 1; i < aux - 1; i++) {
                    num += line.charAt(i);
                }
                for (int i = aux + 1; i < auxi; i++) {
                    rtAux += line.charAt(i);
                }
                if (num.length() < 16) {
                    for (int i = num.length(); i < 16; i++) {
                        numero += 0;
                    }
                    numero += num;
                }
                Integer rt = returnN(rtAux);
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("100011", fi, sec,
                        null, null, null, numero, null);
                TabelaSinais ts = new TabelaSinais("lw");
                tabelas += ts.geraTabela("100011", '1', '0', '1', '0', '0', '1', "00", '0');
            } else if (line.indexOf("sw") >= 0) {
                String word[] = line.split(",");
                Integer rs = returnN(word[0]);
                String rtAux = new String();
                String num = new String();
                String numero = new String();
                int aux = line.indexOf("(");
                int auxi = line.indexOf(")");
                int aux1 = line.lastIndexOf(",");
                for (int i = aux1 + 1; i < aux - 1; i++) {
                    num += line.charAt(i);
                }
                for (int i = aux + 1; i < auxi; i++) {
                    rtAux += line.charAt(i);
                }
                if (num.length() < 16) {
                    for (int i = num.length(); i < 16; i++) {
                        numero += 0;
                    }
                    numero += num;
                }
                Integer rt = returnN(rtAux);
                String f = Integer.toBinaryString(rs);
                String s = Integer.toBinaryString(rt);
                String fi = new String();
                String sec = new String();
                if (f.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        fi += 0;
                    }
                }
                if (s.length() < 5) {
                    for (int i = f.length(); i < 5; i++) {
                        sec += 0;
                    }
                }
                fi += f;
                sec += s;
                Tabela t = new Tabela('i');
                tabelas += t.geraTabela("101011", fi, sec, null, null, null, numero, null);
                TabelaSinais ts = new TabelaSinais("sw");
                tabelas += ts.geraTabela("101011", '0', 'X', '1', '0', '1', 'X', "00", '0');
            } else if (line.indexOf("j") >= 0) {
                String word[] = line.split(",");
                Integer lbl = returnN(word[0]);
                String b = Integer.toBinaryString(lbl);
                String fim = new String();
                if (b.length() < 24) {
                    for (int i = b.length(); i < 24; i++) {
                        fim += "0";
                    }
                    fim += b;
                }

                Tabela t = new Tabela('j');
                tabelas += t.geraTabela("000100", null, null, null, null, null, null, fim);
                TabelaSinais ts = new TabelaSinais("j");
                tabelas += ts.geraTabela("000100", '0', 'X', 'X', 'X', '0', 'X', "XX", '1');
            }
        }
    }

    public void gravaDados() throws IOException {
        File file = new File("assembler");
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        output.write(tabelas);
        output.close();

        FileWriter fr = new FileWriter("C:\\Users\\Gustavo Schroeder\\Documents\\NetBeansProjects\\MipsCompiler\\src\\mipscompiler\\newfile");
        PrintWriter out = new PrintWriter(fr);
        out.print(tabelas);
        out.flush();
        System.out.println("Program has finished");
    }
}
