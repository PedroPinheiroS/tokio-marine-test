# Prova escrita:

# O que é injeção de dependência?
# 1 - Injeção de dependência é um padrão de desenvolvimento utilizado quando é necessário manter baixo o nível de acoplamento entre diferentes classes de um projeto, exemplo que está no projeto:
#    @Autowired
#    public CustomerService(CustomerRepository repository, AddressService addressService) {
#        this.addressService = addressService;
#        this.repository = repository;
#    }


# O que você entende por SOLID?
# 2 - Segregação, um código não deve ser acoplado a outro, cada método deve ser único para realizar uma operação sem depender de outros métodos.

# Você conhece o design patern Strategy? De um exemplo de quando utilizá-lo
# 3 - Sim, o strategy deve ser utilizado quando muitas classes se relacionam e tem apenas modelos de negócios diferentes, com isso a classe possuirá todos os comportamentos necessários sem acoplamento.




# Quais subprojetos da Spring você conhece? Descreva-os brevemente.
# 1 - Spring Batch, Spring Security, Spring MVC.
# São alguns dos subprojetos do spring que conheço, Spring Batch é utilizado para obter dados em um determinado tempo e realizar algum tipo de operação com aqueles dados; Spring security é utilizado para dar segurança a sua aplicação através de alguns metodos como, validação através de tokens podemos utiliza-lo junto do jwt também é utilizado para configurar a aplicação para implementar segurança de ataques etc.

# Como podemos criar e injetar beans no Spring?
# 2 - Existem diversas formas de injetar beans no spring segue alguns exemplos, @Bean, @Componente, @Service, @Configuration etc.

# Como usar transações no Spring?
# 3 - A transação é utilizada pela annotation @Transactional ela é utilizada para realizar commits no banco somente quando todas as ações forem terminadas.


# O que você entende sobre o que são serviços web RESTful?
# 1 - Serviços rest são serviços que visam a performance confiabilidade e capacidade de crescimento rápido, onde é utilizado o padrão stateless e os métodos HTTP GET, HEAD, POST, PUT, PATCH, DELETE e consomem Json ou Xml e responsem Json ou xml.

# Cite algumas boas práticas envolvendo rest?
# 2 - Boas práticas no padrão rest são o retorno dos status codes, padronização do body e do response e das exceptions.

# Cite os métodos HTTP mais usados na arquitetura baseada REST e o que eles fazem?
# 3 - 200 - Ok Utilizado em maior parte pelos métodos Get na busca de algum dado.
#     201 - Created Utilizado em requisições POST na inclusão de algum dado.
#     400 - Bad Request Utilizado em requisições que estão com dados incorretos por parte do client.
#     503 - Service Unavaliable - Serviço Indisponível
#     500 - Internal server Error - Erro de aplicação não tratado
#     206 - Partial Content Utilizado em paginações,
#     204 - No Content Utilizado em Delete.

# Qual a diferença entre os códigos de resposta (status codes) HTTP 200, 400 e 500?
# 4 - Já respondi na questão 3.

# Collection para testar a aplicação :
# https://www.getpostman.com/collections/76be9c0f096e2462c5a7

# Testes unitários implementados, para inicialos apenas utilizar mvn test ou rodar direto pela classe de teste.

# Para maiores informações me contatar no whatsapp ( 18 - 99631 3545 ) ou pedroluis_pinheiro@yahoo.com.br.
