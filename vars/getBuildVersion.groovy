def call() {

    tag_id = sh(script: "git describe --abbrev=0", returnStdout: true)?.trim()

    env.TAG_NAME = tag_id

    if ( BRANCH_NAME == 'master' || BRANCH_NAME == 'hostfix' || BRANCH_NAME == 'release' ) {
        echo "master-hotfix-release"
        env.REVISION_ID = tag_id;
        return "${TAG_NAME}"
    } else if ( BRANCH_NAME == 'develop' || BRANCH_NAME =~ /feature/ ) {
        echo "development-feature-*"
        echo " tag name is :: ${TAG_NAME}-SNAPSHOT"
        env.REVISION_ID = ${TAG_NAME}-SNAPSHOT
        return "${REVISION_ID}"
    } else {
        return null
    }
}
