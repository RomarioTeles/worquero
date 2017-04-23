package jobjob
class SecurityInterceptor {

    SecurityInterceptor() {
        matchAll()
                .except(controller:'login', action:'auth')
    }

    boolean before() {
        /*if (!session.user && actionName != "auth") {
            redirect(controller: "login", action: "auth")
            return false
        }*/
        return true
    }

}