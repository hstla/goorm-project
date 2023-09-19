const Nav = () => {
  return (
    <div className=' flex top-0 justify-between w-full  z-10 items-center p-4 shadow-lg mb-2'>
      <a href='/'>
        Shop
      </a>
      <div>
        <a href='/12'>장바구니</a>
        <a href='/12' className='ml-2'>사용자</a>
        <a href='/12' className='ml-2'>로그인</a>
      </div>
    </div>
  );
}

export default Nav;