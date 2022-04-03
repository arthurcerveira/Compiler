import java.io.*;

enum TokenType{ NUM, SOMA, MULT, SUB, DIV, APar, FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;
	int lexemaAnterior;
	Boolean usarLexemaAnterior = false;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				if (usarLexemaAnterior){
					currchar1 = lexemaAnterior;
					usarLexemaAnterior = false;
				}
				else 
					currchar1 =  arquivo.read();
				
				currchar = (char) currchar1;
				
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10)
			{
				if (currchar >= '0' && currchar <= '9'){
					String lexema = Character.toString(currchar);
					
					currchar1 =  arquivo.read();
					currchar = (char) currchar1;
					
					while(currchar >= '0' && currchar <= '9'){
						lexema = lexema.concat(Character.toString(currchar));
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
					}

					lexemaAnterior = currchar1;
					usarLexemaAnterior = true;

					return (new Token (lexema, TokenType.NUM));
				}
				else
					switch (currchar){
						case '(':
							return (new Token (Character.toString(currchar),TokenType.APar));
						case ')':
							return (new Token (Character.toString(currchar),TokenType.FPar));
						case '+':
							return (new Token (Character.toString(currchar),TokenType.SOMA));
						case '*':
							return (new Token (Character.toString(currchar),TokenType.MULT));
						case '-':
							return (new Token (Character.toString(currchar),TokenType.SUB));
						case '/':
							return (new Token (Character.toString(currchar),TokenType.DIV));
						
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
			}

			arquivo.close();
			
		return (new Token(Character.toString(currchar),TokenType.EOF));
		
	}
}
