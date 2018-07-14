<template>
 <div class="app">

      <div class="slider">
       <slide-show :slides="slides" :inv="invTime"></slide-show>
      </div>

      <div class="icon-show">
        <div class="icon">
          <img src="../assets/logo.png" alt="my icon" title="JesseZalman"/>
        </div>
        <div class="icon-description">
          <img src="../assets/logo.png" alt="my description"/>
        </div>
      </div>

      <div class="post-show">
        <div 
          class="post-categories"
          v-for="(category,index) in categories"
          :key="index"
          @click="currentIndex=index">
          {{category}}
        </div>
        <div class="post-container">
          <p v-for="(article,index) in articles" :key="index">
            <a :href="'/${article.id}'" target="_blank">
            {{article.articleTitle}}<br/>
            {{article.articleDescription}}
            </a>
          </p>
        </div>
      </div>
      

 </div> 
</template>

<script>
import slideShow from '../components/SlideShow'
export default {
  name: 'Index',
  components: {
    slideShow
  },
  data () {
    return {
    invTime: 2000,
    slides: [
      {
        src: require('../assets/slideShow/pic1.jpg'),
        href: ''
      },
      {
        src: require('../assets/slideShow/pic2.jpg'),
        href: ''
      },
      {
        src: require('../assets/slideShow/pic3.jpg'),
        href: ''
      },
      {
        src: require('../assets/slideShow/pic4.jpg'),
        href: ''
      }
    ],  
	  content:{},
	  categories:{},
	  currentIndex:0,
	  url:'http://127.0.0.1:8081/blog/client/articles/list',
    }
  },
  computed:{
    articles(){
	  return this.content[this.currentIndex]&&this.content[this.currentIndex].articles;
	}
  },
   created() {
      this.$axios.get(this.url).then((response) => {
        // success
        this.content = response.data.data;
		this.categories=response.data.data.map(item => item.name);
      }).catch( (error) => {
        // error
        console.log(error)
      });
    }
}
</script>


<style scoped>
h1{
  font:30px/1.5em  "Microsoft YaHei" ,sans-serif;
}
.app{
  position: relative;
}
.slider {
  position:relative;
  float: left;
  width: 900px;
}
.icon-show{
  position: absolute;top: 40px; right: 50px;
  float: left;
}
.post-show{
  position: absolute;top: 500px; left: 95px;
  
}
.post-categories{
  font:30px/1.5em  "Microsoft YaHei" ,sans-serif;
}
.post-container{
  padding-left: 30px;
  font:24px/1.5em  "Microsoft YaHei" ,sans-serif;
}
</style>