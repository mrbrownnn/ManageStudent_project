/*=============== SHOW HIDDEN - PASSWORD ===============*/
const showHiddenPass = (loginPass, loginEye) => {
   const input = document.getElementById(loginPass),
         iconEye = document.getElementById(loginEye)

   iconEye.addEventListener('click', () => {
       // Change password to text
       if(input.type === 'password'){
           // Switch to text
           input.type = 'text'

           // Icon change
           iconEye.classList.add('ri-eye-line')
           iconEye.classList.remove('ri-eye-off-line')
       } else {
           // Change to password
           input.type = 'password'

           // Icon change
           iconEye.classList.remove('ri-eye-line')
           iconEye.classList.add('ri-eye-off-line')
       }
   })
}
showHiddenPass('login-pass','login-eye');
//========SIGN IN======
// Lắng nghe sự kiện submit của form đăng nhập
document.querySelector('.login__form').addEventListener('submit', async (e) => {
    e.preventDefault();
    
    // Lấy tên người dùng và mật khẩu từ form
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-pass').value;
    
    try {
        // Gửi yêu cầu đăng nhập đến API
        const response = await fetch('http://localhost:3000/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        });
        
        // Phân tích dữ liệu trả về từ API
        const result = await response.json();
        
        if (result.success) {
            // Lưu token, student_id và role vào sessionStorage
            sessionStorage.setItem('token', result.token);
            sessionStorage.setItem('student_id', result.student_id);
            sessionStorage.setItem('role', result.role); // Lưu vai trò

            // Điều hướng đến trang profile
            window.location.href = 'profile.html'; 

            // Kiểm tra nếu là admin, chuyển hướng đến trang admin sau khi vào profile
            if (result.role === 'admin') {
                setTimeout(() => {
                    window.location.href = 'admin.html'; // Chuyển sang trang admin
                }, 500); // Đợi 0.5 giây để đảm bảo quá trình tải trang profile
            }
        } else {
            // Xử lý khi đăng nhập thất bại
            alert('Đăng nhập thất bại: ' + result.message);
        }
    } catch (error) {
        // Xử lý lỗi
        console.error('Lỗi:', error);
        alert('Có lỗi xảy ra. Vui lòng thử lại.');
    }
});
