currentBuild.displayName = "Automatizacion con browserstack" + currentBuild.number

import java.text.SimpleDateFormat

def defDateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def defDate = new Date()
def defTimestamp = defDateFormat.format(defDate).toString()

pipeline {

    agent any

    tools {
        maven 'M3'
        jdk 'jdk8.333'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        disableConcurrentBuilds()
    }

    stages {

        stage('Build') {
            steps {
                sh "mvn clean"
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    try {
                        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE', message: 'Test Suite had a failure') {
                            //sh "mvn test -Dcucumber.filter.tags=${ESCENARIO} -Dserenity.features='src/test/resources/features' -Dserenity.stepDefinitions='com.browserstack.stepDefinition'"
                        sh "mvn test -Dcucumber.filter.tags=\"@CASO_PRUEBA_1\" -Dserenity.features=\"src/test/resources/features\" -Dserenity.stepDefinitions=\"com.browserstack.stepDefinition\""
                        }
                    }
                    catch (ex) {
                        echo 'Finalizo ejecucion con fallos...'
                        error('Failed')
                    }
                }
            }
        }

        stage('Reporte') {
            steps {
                script {
                    try {
                        sh "mvn serenity:aggregate"
                        echo 'Ejecucion de pruebas sin errores...'
                        sh "echo ${WORKSPACE}"
                        sh "echo ${defTimestamp}"
                        publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "${WORKSPACE}/target/surefire-reports", reportFiles: 'testng-results.xml', reportName: 'Evidencias de Prueba', reportTitles: 'Reporte de Pruebas'])
                        echo 'Reporte realizado con exito'
                    }
                    catch (ex) {
                        echo 'Reporte realizado con Fallos'
                        error('Failed')
                    }
                }
            }
        }
    }

}
