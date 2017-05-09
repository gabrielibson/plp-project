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

| DeclaracaoStruct

DeclaracaoVariavel ::= Tipo Id "=" Expressao 

DeclaracaoComposta ::= Declaracao "," Declaracao 

DeclaracaoProcedimento ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"

ListaDeclaracaoParametro ::= Tipo Id | Tipo Id "," ListaDeclaracaoParametro

DeclaracaStruct ::= "struct" Id "{" DeclaracaoChave ";" DeclaracacaoVariavel ";" "}"

DeclaracaoChave ::= "key" "int" Id "=" ValorInteiro | "key" "string" Id "=" ValorString

Tipo ::= TipoStruct | TipoPrimitivo

TipoStruct ::= Id

TipoPrimitivo ::= "string" | "int" | "boolean"

While ::= "while" Expressao "do" Comando

IfThenElse ::= "if" Expressao "then" Comando "else" Comando

IO ::= "write" "(" Expressao ")" | "read" "(" Id ")" 
                   | "writeFile" "(" Id "," File ")"
                   | "readFile" "(" Id ":" ValorInteiro | Id ":" ValorString "," File ")"

File ::= Id ".txt"

ChamadaProcedimento ::= "call" Id "(" [ ListaExpressao ] ")" 

ListaExpressao ::= Expressao | Expressao, ListaExpressao
