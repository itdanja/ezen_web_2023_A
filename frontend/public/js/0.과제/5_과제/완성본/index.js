//몬스터 배열
let monsterlist = [
	{ img : 'img/버섯1.gif', hp : 100, left : 910, exp : 50, fullhp: 100},
	{ img : 'img/버섯2.png', hp : 200, left : 910, exp : 100, fullhp: 200},
	{ img : 'img/버섯3.gif', hp : 300, left : 910, exp : 110, fullhp: 300},
	{ img : 'img/버섯4.gif', hp : 400, left : 910, exp : 120, fullhp: 400},
	{ img : 'img/버섯5.gif', hp : 500, left : 910, exp : 130, fullhp: 500},
	{ img : 'img/버섯6.gif', hp : 600, left : 910, exp : 140, fullhp: 600},
	{ img : 'img/버섯7.gif', hp : 700, left : 910, exp : 150, fullhp: 700},
	{ img : 'img/버섯8.gif', hp : 800, left : 910, exp : 160, fullhp: 800},
	{ img : 'img/버섯9.png', hp : 900, left : 910, exp : 170, fullhp: 900},
	{ img : 'img/버섯10.gif', hp : 1000, left : 910, exp : 200, fullhp: 1000}
]
let monster = [monsterlist[0],monsterlist[1],monsterlist[2]]

let character = {
	img : 'img/스폰지밥4.png',
	left: 10,
	exp : 0,
	lev : 1,
	power : 20,
	hp : 100
}
//1. userbox Dom객체 가져오기
let userbox = document.querySelector('.userbox')
let logbox = document.querySelector('.logbox')
let logbox2 = document.querySelector('.logbox2')
let monbox1 = document.querySelector('.monbox1')
let monbox2 = document.querySelector('.monbox2')
let monbox3 = document.querySelector('.monbox3')
let m_hp1 = document.querySelector('.m_hp1')
let m_hp2 = document.querySelector('.m_hp2')
let m_hp3 = document.querySelector('.m_hp3')
let u_hp = document.querySelector('.u_hp')
let expbar = document.querySelector('.expbar')

let mindex=2;

let defense = true

print_ch()

//2. 문서 안에서 키 입력 이벤트
document.addEventListener('keydown' , (e) => {
	
	let key = e.keyCode;
	if( key == 37){//왼쪽키
		character.left -= 10
		character.left = character.left < 0 ? 0 : character.left ; //만약에 차감된 왼쪽 촤표가 0보다 작으면 0으로 고정
		if(character.hp>0){userbox.style.backgroundImage = `url(img/스폰지밥6.png)`}
	}else if(key == 39){//오른쪽키
		character.left += 10
		character.left = character.left > 900 ? 900 : character.left ;
		if(character.hp>0){userbox.style.backgroundImage = `url(img/스폰지밥5.png)`}
	}else if(key == 65){//a키 : 공격
		userbox.style.backgroundImage = `url(img/스폰지밥.png)`
		attack(mindex,distance())
	}
	else if(key == 83){//s키 : 방어
		userbox.style.backgroundImage = `url(img/방어.png)`
		defense = false
	}
	userbox.style.left =`${character.left}px`
	
	logbox.innerHTML = `<div> 캐릭터좌표 : ${character.left}</div>`
})
// 2. 문서 안에서 키 떼었을때 이벤트 keyup
document.addEventListener('keyup' , (e) => {
	if(character.hp<=0){userbox.style.backgroundImage = `none`}
	else{userbox.style.backgroundImage = `url(${character.img})`}
	if(monster[0].hp!=0 || monster[1].hp!=0 || monster[2].hp!=0){defense=true}
})


//몬스터 이동 난수
setInterval(mon_moving , 1000)

function mon_moving(){
	if(defense==true){damage(distance())}
	for(let i =0 ; i<3 ; i++){
		let rand = parseInt(Math.random()*100+1);
		let rand2 = parseInt(Math.random()*2);
		
		if(rand2==1){monster[i].left += rand}
		else{monster[i].left -= rand}
		
		if(monster[i].left<0){ monster[i].left=0;}
		if(monster[i].left>900) {monster[i].left=900}
		
		if(i==0){monbox1.style.left =`${monster[i].left}px`}
		else if(i==1){monbox2.style.left =`${monster[i].left}px`}
		else{monbox3.style.left =`${monster[i].left}px`}
		
		logbox2.innerHTML = `<div> 몬스터좌표 : ${monster[i].left}</div>`
	}
}

function distance(){
	let d = 0;
	let one =Math.abs(monster[0].left-character.left)
	let two = Math.abs(monster[1].left-character.left)
	let three = Math.abs(monster[2].left-character.left)
	
	if(Math.min(one,two,three)==two){d=1}
	if(Math.min(one,two,three)==three){d=2}
	if(Math.min(one,two,three)==one){d=0}
	return d;
}

let exp = true
//공격하기!
function attack(index,i){//공격함
	let monbox
	let m_hp
	let n
	if(i==2){monbox=monbox3; m_hp=m_hp1; n=1; }
	else if(i==1){monbox=monbox2; m_hp=m_hp2; n=2;}
	else{monbox=monbox1; m_hp=m_hp3; n=3; }
	
	if(monster[i].left-character.left<130){//공격범위
		monster[i].hp -= character.power;	
		if(monster[i].hp <=0 ){mindex++ //몬스터 체력 0이면 
			monster[i].hp = 0;
			if(exp){
				character.exp += monster[i].exp
				print_ch()
			}
			if(mindex<monsterlist.length){ //마지막 몬스터가 아니면
				monster.splice(i,1,monsterlist[mindex])
				monbox.style.backgroundImage = `url(${monster[i].img})`
				m_hp.style.width = `${parseInt((monster[i].hp/monster[i].fullhp)*100)}%`
				document.querySelector('.m_hp'+n).innerHTML = monster[i].hp
			}
			else if(monster[0].hp==0 && monster[1].hp==0 && monster[2].hp==0){
				//마지막 몬스터면 
				monbox.style.backgroundImage = `none`
				document.querySelector('.gameover').innerHTML = `WIN`
				defense = false
				exp =false
			}
			else{monbox.style.backgroundImage = `none`}
		}
		m_hp.style.width = `${parseInt((monster[i].hp/monster[i].fullhp)*100)}%`
		console.log('%'+parseInt((monster[i].hp/monster[i].fullhp)*100))
		document.querySelector('.m_hp'+n).innerHTML = monster[i].hp
	}
	
}



//공격받음
function damage(i){
	if(monster[i].left-character.left<90){//공격받음
			let rand = parseInt(Math.random()*10+1);
			character.hp -= rand
			if(character.hp<=0){ //내가 죽으면
				document.querySelector('.gameover').innerHTML = `GAME OVER`
				userbox.style.backgroundImage = `none`
				character.hp = 0
			}
			u_hp.style.width = `${character.hp}%`
			document.querySelector('.u_hp').innerHTML = character.hp
		}
}

// 캐릭터 능력창
function print_ch(){
	while(true){ // 경험치가 백 되면 레벨업 
		if(character.exp>=100){
			character.lev += 1
			character.exp -= 100
		}
		else{break}
	}
	character.power=character.lev*20
	document.querySelector('.lev').innerHTML = `레벨 : ${character.lev}`
	document.querySelector('.power').innerHTML = `공격력 : ${character.power}`
	document.querySelector('.expbar').innerHTML = character.exp
	expbar.style.width = `${character.exp}%`
}



