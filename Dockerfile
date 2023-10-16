#diz qual tipo de ambiente vai rodar no conatiner linux, uma aplicação maven com openjdk17
FROM maven:4.0.0-openjdk-17

#guarda informação de destino da build do projeto na variavel project_home e guarda o nome do jar na jar_name
ENV PROJECT_HOME /usr/src/copapp
ENV JAR_NAME copapp.jar

# (mkdir comando para criar diretorio) cria o diretorio com o nome da variavel, define diretorio de trabalho do docker
# diretorio que acabou de criar
RUN mkdir -p $PROJECT_HOME
WORKDIR $PROJECT_HOME

# copia todos os arquivos
COPY . .

RUN mvn clean package -DskipTests

# Move file
RUN mv $PROJECT_HOME/target/$JAR_NAME $PROJECT_HOME/

#ativa o profile prod do app.properties
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "copapp.jar"]