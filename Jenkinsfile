pipeline {

    agent { label 'Agent' }

    parameters {
        string(name: 'object_kind', defaultValue: 'Manual', description: 'Object Kind: Push or Merge Request')
        string(name: 'user_name', defaultValue: 'Manual', description: 'Username who does the changes in the repo')
        string(name: 'user_email', defaultValue: 'angela.duquino@appgate.com', description: 'User email')
        string(name: 'total_commits_count', defaultValue: '0', description: 'Total commits done')
        string(name: 'commit_messages', defaultValue: 'Manual', description: 'Commit messages done')
    }

    stages {

        stage('Clean - Package - Unit Test') {
            steps {
                echo 'Clean - Run Unit Test - Package'
                sh 'mvn clean package'
            }
        }

        stage('Functional Test') {
            steps {
                echo 'Testing'
                sh 'sh functional-test/run-test.sh'
            }
        }

    }

    post {

        always {
            notifyEmail()
            notifyTeams()
            junit 'target/surefire-reports/*.xml'
             cucumber buildStatus: 'UNSTABLE',
                                     fileIncludePattern: '*cucumber.json',
                                     jsonReportDirectory: 'functional-test/target/CucumberReports/'
        }

    }

}

def notifyEmail() {
    emailext(
            subject: '${BUILD_STATUS}: ${JOB_NAME} Build #${BUILD_NUMBER}',
            body: '''
        Execution:
            Request Type: ${object_kind}
            By the user: ${user_name}
            With the commits: ${commit_messages}
        More information in the following link and check the Artifacts section: \n ${RUN_DISPLAY_URL}''',
            to: user_email)
}

def notifyTeams() {
    office365ConnectorSend webhookUrl: 'https://outlook.office.com/webhook/9b30ff33-93c6-4306-94b2-0539df38b6ee@b93e809a-49c5-4a0f-a606-82b846acc30d/JenkinsCI/dd978fb630824e41897649eaaa291b6c/572fabb9-363f-4ff0-8e0d-f60d16044ff7',
            factDefinitions: [[name: "Request Type", template: '${object_kind}'],
                              [name: "By the user", template: '${user_name}'],
                              [name: "With the commits:", template: '${commit_messages}']]
}