<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'posts.label', default: 'Post')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-post" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-post" class="container" role="main" >
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="alert-danger" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.post}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.post}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form action="save">
                <fieldset class="fieldset">
                    %{--<f:all bean="post" except="employer"/>--}%

                    <div class="form-group">
                        <label for="title">${message(code: 'post.title')}</label>
                        <input type="text" class="form-control" name="title" id="title" value="${this.post.title}" placeholder="${message(code: 'post.title')}">
                    </div>
                    <div class="form-group">
                        <label for="overView">${message(code: 'post.overView')}</label>
                        <g:textArea type="text" class="form-control" name="overView" id="overview" value="${this.post.overView}"/>
                    </div>

                    <div class="form-group">
                        <label for="type">${message(code: 'post.type')}</label>
                        <g:select class="form-control" name="type" from="${jobjob.Type.values()}"  keys="${jobjob.Type.values()}" valueMessagePrefix="enum.type" value="${this.post.type}" />
                    </div>

                    <div class="form-group">
                        <label for="responsibility">${message(code: 'post.responsibility')}</label>
                        <g:textArea class="form-control" type="text" name="responsibility" id="responsibility" value="${this.post.responsibility}"/>
                    </div>

                    <div class="form-group">
                        <label for="mustHave">${message(code: 'post.mustHave')}</label>
                        <g:textArea class="form-control" type="text" name="mustHave" id="mustHave" value="${this.post.mustHave}"/>
                    </div>

                    <div class="form-group">
                        <label for="niceToHave">${message(code: 'post.niceToHave')}</label>
                        <g:textArea class="form-control" type="text" name="niceToHave" id="niceTohave" value="${this.post.niceToHave}"/>
                    </div>
                    <div class="form-group">
                        <label for="salary">${message(code: 'post.salary')}</label>
                        <input type="text" class="form-control" name="salary" id="salary" placeholder="${message(code: 'post.salary')}" value="${this.post.salary}"/>
                    </div>
                    <div class="form-group">
                        <label for="beneficity">${message(code: 'post.beneficity')}</label>
                        <input type="text" class="form-control" name="beneficity" id="beneficity" placeholder="${message(code: 'post.beneficity')}" value="${this.post.beneficity}"/>
                    </div>

                    <div class="form-group">
                        <label for="expirationDate">${message(code: 'post.expirationDate')}</label>
                        <input type="date" class="form-control" name="expirationDate" id="expirationDate" value="${this.post.expirationDate}"/>
                    </div>

                    <div class="form-group">
                        <label for="category">${message(code: 'post.category')}</label>
                        <g:select from="${categories}" optionKey="id" optionValue="title" class="form-control" name="category" id="category" value="${this.post.category}" />
                    </div>


                </fieldset>
                <fieldset>
                    <g:submitButton name="create" class="btn btn-primary" value="${message(code: 'default.button.create.label')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
