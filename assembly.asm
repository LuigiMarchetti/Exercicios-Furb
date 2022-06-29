        MOV 00,B;
		MOV 00,C;
		MOV 00,D;
		MOV 00,E;
		JMP RECEBER;

RECEBER:
		MOV IN0,A;
		SUB 01,A;
		JMPZ INCREMENTOLEDS1;

		MOV IN0,A;
		SUB 02,A;
		JMPZ DECREMENTOLEDS1;

		MOV IN0,A;
		SUB 04,A;
		JMPZ INCREMENTOLEDS2;

		MOV IN0,A;
		SUB 08,A;
		JMPZ DECREMENTOLEDS2;

		JMP IMPRIMIR;

IMPRIMIR:
		MOV B,A;
		MOV A,OUT3;
		MOV C,A;
		MOV A,OUT2;
		MOV D,A;
		MOV A,OUT1;
		MOV E,A;
		MOV A,OUT0;

INCREMENTOLEDS1:
		MOV B,A;
		ADD C,A;
		SUB 12,A;
		JMPZ RECEBER;
		MOV B,A;
		INC A,B;
		MOV B,A;
		SUB 0A,A;
		JMPZ INCDEZ1;
		JMP IMPRIMIR;

INCDEZ1: //INCREMENTA DEZENA NO LED
		MOV 00,B;
		MOV C,A;
		INC A,C;
		JMP IMPRIMIR;

INCREMENTOLEDS2:
		MOV D,A;
		ADD E,A;
		SUB 12,A;
		JMPZ RECEBER;
		MOV D,A;
		INC A,D;
		MOV D,A;
		SUB 0A,A;
		JMPZ INCDEZ2;
		JMP IMPRIMIR;

INCDEZ2:
		MOV 00,D;
		MOV E,A;
		INC A,E;
		JMP IMPRIMIR;

DECREMENTOLEDS1:
		MOV B,A;
		ADD C,A;
		SUB 00,A;
		JMPZ RECEBER;
		MOV B,A;
		SUB 00,A;
		JMPZ CONTROLEDEZENA01;
		MOV B,A;
		SUB 01,A;
		MOV A,B;
		JMP IMPRIMIR;

CONTROLEDEZENA01: //DECREMENTE A DEZENA LED
		MOV 09,B;
		MOV C,A;
		SUB 01,A;
		MOV A,C;
		JMP IMPRIMIR;

DECREMENTOLEDS2:
		MOV D,A;
		ADD E,A;
		SUB 00,A;
		JMPZ RECEBER;
		MOV D,A;
		SUB 00,A;
		JMPZ CONTROLEDEZENA02;
		MOV D,A;
		SUB 01,A;
		MOV A,D;
		JMP IMPRIMIR;

CONTROLEDEZENA02:	
		MOV 09,D;
		MOV E,A;
		SUB 01,A;
		MOV A,E;
		JMP IMPRIMIR;