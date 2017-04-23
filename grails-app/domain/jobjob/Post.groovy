package jobjob

import grails.databinding.BindingFormat

class Post {

    @BindingFormat('yyyy-MM-dd')
    Date expirationDate
    Date creationDate
    String salary
    String title
    String overView
    String niceToHave
    String mustHave
    String responsibility
    String beneficity
    Type type
    Category category
    String address

    static belongsTo = [employer : Company]

    Post(){
        creationDate = new Date()
    }

    static constraints = {
        salary nullable: true
        mustHave nullable: true
        niceToHave nullable: true
        responsibility nullable: true
        beneficity nullable: true
        address nullable: true
        expirationDate nullable: true
        employer nullable: true
    }

    static mapping = {
        id generator: 'sequence', params: [sequence: 'post_seq']
        expirationDate type: 'date'
    }
}
