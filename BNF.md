# BNF (Backus-Naur form)

```
Programa ::= Comando

Comando ::= Atribuicao

| ComandoDeclaracao

| While

| IfThenElse

| IO

| Comando ";" Comando

| Skip

| ChamadaProcedimento

Skip ::=

Atribuicao ::= LeftExpression ":=" Expressao

Expressao ::= Valor | ExpUnaria | ExpBinaria | Id

Valor ::= ValorConcreto

ValorConcreto ::= ValorInteiro | ValorBooleano | ValorString

ExpUnaria ::= "-" Expressao | "not" Expressao | "length" Expressao

ExpBinaria ::= Expressao "+" Expressao

| Expressao "-" Expressao

| Expressao "and" Expressao

| Expressao "or" Expressao

| Expressao "==" Expressao

| Expressao "++" Expressao

LeftExpression ::= Id | AcessoAtributo

AcessoAtributo ::= LeftExpression.Id

ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"

Declaracao ::= DeclaracaoVariavel

| DeclaracaoProcedimento

| DeclaracaoComposta

| DefStruct

| InstanciaStruct


DeclaracaoVariavel ::= "var" Id "=" Expressao

DecVariavelStruct ::= Tipo Id

DeclaracaoComposta ::= Declaracao "," Declaracao 

DeclaracaoProcedimento ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"

ListaDeclaracaoParametro ::= Tipo Id | Tipo Id "," ListaDeclaracaoParametro

ListaDecVariavelStruct ::= DecVariavelStruct | DecVariavelStruct ";" ListaDecVariavelStruct

DefStruct ::= "struct" Id "{" DeclaracaoChave ";" ListaDecVariavelStruct "}"

InstanciaStruct ::= InstanciaValoresStruct | InstanciaLeituraStruct

InstanciaValoresStruct ::= Tipo Id "=" "[" ListaExpressao "]"

InstanciaLeituraStruct ::= Tipo Id "=" "readFile" "(" Key "," File ")"

Key ::= ValorInteiro

DeclaracaoChave ::= "int" Id

Tipo ::= TipoStruct | TipoPrimitivo

TipoStruct ::= Id

TipoPrimitivo ::= "string" | "int" | "boolean"

While ::= "while" Expressao "do" Comando

IfThenElse ::= "if" Expressao "then" Comando "else" Comando

IO ::= "write" "(" Expressao ")" | "read" "(" Id ")" 
                   | "writeFile" "(" Id "," File ")"
                   | Id "=" "readFile" "(" Key "," File ")"
                   

File ::= ValorString

ChamadaProcedimento ::= "call" Id "(" [ ListaExpressao ] ")" 

ListaExpressao ::= Expressao | Expressao, ListaExpressao





{
 struct aluno{
  int id;
  string nome;
  string matricula;
},
  aluno a1 = [1,"fulano","12"];
  
  writeFile(a1,File);
}

OBS: Os arquivos terão a primeira linha com o tipo do struct


