package jobjob

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	public static final String ADMIN = 'ROLE_ADMIN'
	public static final String USER = 'ROLE_USER'
	public static final String IS_AUTHENTICATED_FULLY = 'IS_AUTHENTICATED_FULLY'
	public static final String IS_AUTHENTICATED_REMEMBERED = 'IS_AUTHENTICATED_REMEMBERED'

	String authority

	static constraints = {
		authority blank: false, unique: true
	}

	static mapping = {
		cache true
		id generator: 'sequence', params: [sequence: 'role_seq'], sqlType: "serial"
	}
}
