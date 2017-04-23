package jobjob

import grails.util.Environment

import javax.persistence.RollbackException

class BootStrap {

    def init = { servletContext ->

        switch (Environment.current) {
            case Environment.DEVELOPMENT:

                def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
                def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

                def admin = new User(username: "admin", password: "admin", email: 'admin@admin.com', enabled: true)
                admin.beforeInsert()
                admin.save(flush: true)
                UserRole.create(admin, adminRole).save()
                UserRole.create(admin, userRole).save()

                def user = new User(username: "user", password: "user", email: 'user@user.com', enabled: true)
                user.encodePassword()
                user.save(flush: true)
                UserRole.create(user, userRole).save()

                break
            case Environment.PRODUCTION:
                break
        }

        /*for (String url in [
                '/', '/index', '/index.gsp', '*//**//*favicon.ico',
                '/assets*//**', '*//**//*js*//**', '*//**//*css*//**', '*//**//*images*//**',
                '/login*//*',
                '/logout']) {

            if(url == '/login*//*'){
                new Requestmap(url: url, configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()
            }
            else if(url == '/logout'){
                new Requestmap(url: url, configAttribute: 'IS_AUTHENTICATED_REMEMBERED,IS_AUTHENTICATED_FULLY').save()
            }
            else {
                new Requestmap(url: url, configAttribute: 'permitAll').save()
            }
        }*/

    }
    def destroy = {
    }
}
