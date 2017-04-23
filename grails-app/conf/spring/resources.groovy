import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder

beans = {
    passwordEncoder(PlaintextPasswordEncoder)
    userDetailsService(CustomUserDetailsService){
            grailsApplication = ref('grailsApplication')
    }
}
