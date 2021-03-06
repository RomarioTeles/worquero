environments {
	production {
		dataSource {
			dbCreate = "update"
			driverClassName = "org.postgresql.Driver"
			dialect = org.hibernate.dialect.PostgreSQL9Dialectlect
			uri = new URI(System.env.DATABASE_URL?:"localhost:5432/jobjobdb")
			url = "jdbc:postgresql://" + uri.host + ":" + uri.port + uri.path
			username = uri.userInfo.split(":")[0]
			password = uri.userInfo.split(":")[1]
		}
	}
}

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'jobjob.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'jobjob.UserRole'
grails.plugin.springsecurity.authority.className = 'jobjob.Role'
//grails.plugin.springsecurity.requestMap.className = 'jobjob.Requestmap'
grails.plugin.springsecurity.securityConfigType = "Annotation"

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/**',               access: ['IS_AUTHENTICATED_FULLY']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets*//**',      access: ['permitAll']],
	[pattern: '*//**//*js*//**',       access: ['permitAll']],
	[pattern: '*//**//*css*//**',      access: ['permitAll']],
	[pattern: '*//**//*images*//**',   access: ['permitAll']],
	[pattern: '*//**//*favicon.ico', access: ['permitAll']],
	[pattern: '/login/**', access: ['IS_AUTHENTICATED_ANONYMOUSLY']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.password.algorithm = 'SHA-256'
grails.plugin.springsecurity.password.hash.iterations = 1

grails.plugin.springsecurity.auth.loginFormUrl = '/login'
grails.plugin.springsecurity.logout.postOnly = false