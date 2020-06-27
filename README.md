# Controle de medicamentos em uma Drogaria.

## JAVA+MySQL+Swing+JFreeChart


![Projeto Java](https://i.imgur.com/pkZe2O2.png)

# instalação

### ```Passo a Passo```

### 1 - Crie um banco de dados com o nome:  a5_arquitetura

### 2 - Va na aba "SQL" e execute o comando:
      DROP TABLE IF EXISTS `remedios`;

      CREATE TABLE IF NOT EXISTS `remedios` (

     `ID_do_Banco` int(11) NOT NULL AUTO_INCREMENT,
 
     `Id` int(11) NOT NULL,
 
     `nomeMar` varchar(450) NOT NULL,

     `nomeGen` varchar(450) NOT NULL,

     `laboratorio` varchar(450) NOT NULL,

     `quantidade` int(11) NOT NULL,

     `preco` double NOT NULL,
 
     PRIMARY KEY (`ID_do_Banco`),

    )

### 3 - Va no inicio do projeto procure a pasta Dados_DB
```
copie o arquivo MOCK_DATA.csv
e cole  na area de trabalho ou qualquer outro lugar.
```

### 4  - Execute o projeto e desfrute!
