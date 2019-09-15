
/** @return The tag name, or `null` if the current commit isn't a tag. */
String gitTagName() {
    commit = getCommit()
    if (commit) {
        desc = sh(script: "git describe --tags ${commit}", returnStdout: true)?.trim()
        if (isTag(desc)) {
            return desc
        }
    }
    return null
}

/** @return The tag message, or `null` if the current commit isn't a tag. */
String gitTagMessage() {
    name = gitTagName()
    msg = sh(script: "git tag -n10000 -l ${name}", returnStdout: true)?.trim()
    if (msg) {
        return msg.substring(name.size()+1, msg.size())
    }
    return null
}

@NonCPS
boolean isTag(String desc) {
    match = desc =~ /.+-[0-9]+-g[0-9A-Fa-f]{6,}$/
    result = !match
    match = null // prevent serialisation
    return result
}

String getCommit() {
    return sh(script: 'git rev-parse HEAD', returnStdout: true)?.trim()
}



def call() {
    
    env.TAG_NAME = gitTagName()    
 
    echo "BRANCH_NAME is :: ${BRANCH_NAME} & TAG_NAME is :: ${TAG_NAME}"  
    if ( BRANCH_NAME == 'master' || BRANCH_NAME == 'hostfix' || BRANCH_NAME == 'develop' ) {
         echo "master-hotfix-develop"
         return "${VERSION_NUMBER}"
    } else if ( BRANCH_NAME == 'release' || ( BRANCH_NAME ==~ 'feature-*' &&  TAG_NAME ==~ 'release-*' ) ) {
         echo "release-feature-*"
         return "${VERSION_NUMBER}-SNAPSHOT"
    } else {
         return null
    }

}
