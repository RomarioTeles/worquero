package jobjob

import grails.rest.Resource

/**
 * Created by romario on 02/04/17.
 */
class Company {
    String aboutUs
    String name
    String link
    String picture

    static hasMany=[posts:Post]

    static constraints = {
        aboutUs nullable: true
        link nullable : true
        picture nullable: true
    }

    static mapping = {
        id generator: 'sequence', params: [sequence: 'company_seq']
    }
}
