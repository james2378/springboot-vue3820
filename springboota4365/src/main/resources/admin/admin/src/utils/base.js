const base = {
    get() {
                return {
            url : "http://localhost:8080/springboota4365/",
            name: "springboota4365",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboota4365/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "旧物置换网站"
        } 
    }
}
export default base