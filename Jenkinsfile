pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ronaldjCate/automatizacion_browserstack.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Dcucumber.filter.tags=${ESCENARIO} -Dserenity.features="src/test/resources/features" -Dserenity.stepDefinitions="com.browserstack.stepDefinition"'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/site/serenity/**/*', fingerprint: true
            }
        }
    }

    post {
        always {
            junit 'target/failsafe-reports/*.xml'
        }
        failure {
            echo "Las pruebas han fallado. Revisa los logs."
        }
    }
}
