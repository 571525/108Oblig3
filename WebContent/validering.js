/**
 * 
 */
function passordMatcher(input) {
	if (input.value != document.getElementById('passord').value) {
		input.setCustomValidity('Passordene skal matche.');
	} else {
		input.setCustomValidity('');
	}
}

function passordErValid(input) {
	let reg = /(?=.*[a-zæøå])(?=.*[A-ZÆØÅ])(?=.*[0-9])(?=.{4,})/;
	if (!reg.test(input.value)) {
		input
				.setCustomValidity('Skal ha stort og lille bokstav, minimum 4 langt og ingen mellemrom - skal opfylles');
	} else {
		input.setCustomValidity('');
	}
}

function sjekkPassord(input) {

	let sterkt = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/;
	let middels = /^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{4,7}$)/;

    if (middels.test(input.value)) {
		input.setCustomValidity('');
		let i = document.getElementById('passIndik');
		i.innerHTML = 'MIDDELS';
		i.style.color = 'yellow';
	} else if (sterkt.test(input.value)) {
		input.setCustomValidity('');
		let i = document.getElementById('passIndik');
		i.innerHTML = 'STERKT';
		i.style.color = 'green';
	} else {
		input.setCustomValidity('UGYLDIGT - Skal ha tall, stort og lille bokstav og ha mer enn 4 karakterer');
		let i = document.getElementById('passIndik');
		i.innerHTML = 'SVAGT';
		i.style.color = 'red';
	}

}