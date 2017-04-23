package jobjob

import grails.rest.Resource

class Category {

    String title

    static constraints = {
    }
    static mapping = {
        id generator: 'sequence', params: [sequence: 'category_seq']
    }
}
