
let html = ``;

for( let i = 1 ; i<=20 ; i++ ){
	if( i % 5 == 0 ) html += `<br/>`
	html += `<button onclick="seatSelect()" type="button">${ i }</button>`;
}



document.querySelector('.seatBox').innerHTML = html;

