def call() {

   tag_id = sh(script: "git describe --abbrev=0", returnStdout: true)?.trim()

   env.TAG_NAME = tag_id

   if ( BRANCH_NAME == 'master' || BRANCH_NAME == 'hostfix' || BRANCH_NAME == 'release' ) {
       echo "master-hotfix-release"
       return "${TAG_NAME}"
   } else if ( BRANCH_NAME == 'development' || ( BRANCH_NAME =~ /feature/ &&  TAG_NAME =~ /release/ ) ) {
       echo "development-feature-*"
       return "${TAG_NAME}-SNAPSHOT"
   } else {
       return null
   }

}
