/**Função Para Rolagem de Tela */
const menuItems = document.querySelectorAll('.menu a[href^="#"]');

menuItems.forEach(item =>{
    item.addEventListener('click', scrollToIdUnClick);
})

function scrollToIdUnClick(event){
    event.preventDefault();
    const element = event.target;
    const id = element.getAttribute('href');
    const section =document.querySelector(id).offsetTop;
    window.scroll({
        top:to,
        behavior:'smooth',
    });  
        
}

function menuMobile(){
    const activeMenu = document.querySelector('.fa-bars');
    const navMenu = document.querySelector('header .navegacao-primaria');
    
    
    activeMenu.addEventListener('click',()=>{
        activeMenu.classList.toggle('fa-x');
        navMenu.classList.toggle('ativado');
    });

}
menuMobile();


    
aboutMe();

function removeClick(index){
    buttomGeral.forEach((item)=>{
        item.classList.remove('.active');
    });
    buttomGeral[index].classList.add('.active')
}

buttomGeral.forEach((item, index)=>{
    item.addEventListener('click',()=>{
        removeClick(index);
    })
    
})

