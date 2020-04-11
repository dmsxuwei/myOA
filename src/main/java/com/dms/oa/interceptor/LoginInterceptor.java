package com.dms.oa.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dms.oa.po.Resources;

/**
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//鑾峰彇璇锋眰鐨剈rl
		String url = request.getRequestURI();
		//System.out.println("url:"+url);
		if(url.indexOf("/oa/tologin.do")>=0||url.indexOf("/oa/login.do")>=0
				||url.indexOf("/oa/toRegister.do")>=0||url.indexOf("/oa/register.do")>=0){
			System.out.println("不拦截");
			return true;
		}
		
		HttpSession session  = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username != null){
			System.out.println("已登陆");
			List<Resources> resources=(List<Resources>) session.getAttribute("resources");
			for(int i=0;i<resources.size();i++){
				//System.out.println(resources.get(i).getAddr());
			}
			
			return true;
		}
		
		System.out.println("没有权限!！");
		String path = (String)request.getContextPath();
		System.out.println("path="+path);
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	//杩涘叆Handler鏂规硶涔嬪悗锛岃繑鍥瀖odelAndView涔嬪墠鎵ц
	//搴旂敤鍦烘櫙浠巑odelAndView鍑哄彂锛氬皢鍏敤鐨勬ā鍨嬫暟鎹�姣斿鑿滃崟瀵艰埅)鍦ㄨ繖閲屼紶鍒拌鍥撅紝涔熷彲浠ュ湪杩欓噷缁熶竴鎸囧畾瑙嗗浘
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//System.out.println("HandlerInterceptor1...postHandle");
		
	}

	//鎵цHandler瀹屾垚鎵ц姝ゆ柟娉�
	//搴旂敤鍦烘櫙锛氱粺涓�紓甯稿鐞嗭紝缁熶竴鏃ュ織澶勭悊
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		//request.getRequestDispatcher("/login.jsp").forward(request, response);
		//System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
