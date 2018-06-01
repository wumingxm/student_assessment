
package com.student_assessment.controller;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerifyCodeController {

	private static final long serialVersionUID = 1L;

	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s);
		int g = s + random.nextInt(e - s);
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}
	@RequestMapping("/generateVerifyCode")
	public void generateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0L);
		response.setContentType("image/jpeg");
		int width = 86;
		int height = 22;
		BufferedImage image = new BufferedImage(width, height, 1);
		Graphics g = image.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		Random random = new Random();
		Font mfont = new Font("宋体", 1, 16);
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(mfont);
		g.setColor(getRandColor(180, 200));
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			BasicStroke bs = new BasicStroke(2.0F, 0, 2);
			Line2D line = new java.awt.geom.Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line);
		}

		String sRand = "";
		String ctmp = "";
		int itmp = 0;
		for (int i = 0; i < 4; i++) {
			switch (random.nextInt(3)) {
			case 1: // '\001'
				itmp = random.nextInt(26) + 65;
				ctmp = String.valueOf((char) itmp);
				break;

			case 2: // '\002'
				String rBase[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
				int r1 = random.nextInt(3) + 11;
				String str_r1 = rBase[r1];
				int r2;
				if (r1 == 13)
					r2 = random.nextInt(7);
				else
					r2 = random.nextInt(16);
				String str_r2 = rBase[r2];
				int r3 = random.nextInt(6) + 10;
				String str_r3 = rBase[r3];
				int r4;
				if (r3 == 10)
					r4 = random.nextInt(15) + 1;
				else if (r3 == 15)
					r4 = random.nextInt(15);
				else
					r4 = random.nextInt(16);
				String str_r4 = rBase[r4];
				byte bytes[] = new byte[2];
				String str_12 = (new StringBuilder(String.valueOf(str_r1))).append(str_r2).toString();
				int tempLow = Integer.parseInt(str_12, 16);
				bytes[0] = (byte) tempLow;
				String str_34 = (new StringBuilder(String.valueOf(str_r3))).append(str_r4).toString();
				int tempHigh = Integer.parseInt(str_34, 16);
				bytes[1] = (byte) tempHigh;
				break;

			default:
				itmp = random.nextInt(10) + 48;
				ctmp = String.valueOf((char) itmp);
				break;
			}
			sRand = (new StringBuilder(String.valueOf(sRand))).append(ctmp).toString();
			Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
			g.setColor(color);
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(0.78500000000000003D, 15 * i + 8, 7D);
			float scaleSize = random.nextFloat() + 0.8F;
			if (scaleSize > 1.0F)
				scaleSize = 1.0F;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15 * i + 18, 14);
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("verifyCode", sRand);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}
}
